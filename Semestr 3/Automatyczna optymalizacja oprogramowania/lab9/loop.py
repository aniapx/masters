# python3 loop.py

import subprocess
import random
import threading

process_lock = threading.Lock()

def read_tile_sizes(file_path):
    with open(file_path, 'r') as f:
        lines = f.readlines()
        return [int(line.strip()) for line in lines]

def write_tile_sizes(file_path, values):
    with open(file_path, 'w') as f:
        for value in values:
            f.write(str(value) + '\n')

def generate_random_tile_sizes():
    return [random.randint(2, 256) for _ in range(3)]

def evenly_spaced_values(min_value, max_value, num_values):
    step = (max_value - min_value) / (num_values - 1)
    values = [int(min_value + i * step) for i in range(num_values)]
    return values

def run_pluto_program(matrix1_file, matrix2_file, result_file, matrix_size):
    cmd_compile = 'polycc mMux.c --tile --parallel'
    cmd_build = 'gcc mMux.pluto.c -lm -o muxpluto'
    cmd_execute = f'./muxpluto {matrix1_file} {matrix2_file} {result_file} {matrix_size}'

    subprocess.run(cmd_compile, shell=True, check=True)
    subprocess.run(cmd_build, shell=True, check=True)

    try:
        with process_lock:  # Acquire the lock to ensure sequential execution
            result = subprocess.run(cmd_execute, shell=True, capture_output=True, text=True, timeout=10)  # Adjust the timeout as needed

        printed_value = result.stdout.strip()
        return printed_value
    except subprocess.TimeoutExpired:
        print("Execution timed out. Consider increasing the timeout or handling timeouts differently.")
        return None


# Main
tile_sizes_file = 'tile.sizes'
matrix1_file = 'matrix1.txt'
matrix2_file = 'matrix2.txt'
result_file = 'result.txt'
values_file = 'values.txt'

matrix_size = 1000
iterations_count = 10
iterations_per_loop_count = iterations_count // 3

min_value = 2
max_value = 256

# Clear the values.txt file
with open(values_file, 'w') as f:
    f.write('')

x_tile_sizes = evenly_spaced_values(min_value, max_value, iterations_per_loop_count)
for i in x_tile_sizes:
    y_tile_sizes = evenly_spaced_values(min_value, max_value, iterations_per_loop_count)

    for j in y_tile_sizes:
        z_tile_sizes = evenly_spaced_values(min_value, max_value, iterations_per_loop_count)

        for k in z_tile_sizes:
            print(" =========> Iteration: " + str(i) + "/" + str(j) + "/" + str(k))
            # new_tile_sizes = generate_random_tile_sizes()
            new_tile_sizes = [i, j, k]
            write_tile_sizes(tile_sizes_file, new_tile_sizes)

            printed_value = run_pluto_program(matrix1_file, matrix2_file, result_file, matrix_size)

            with open(values_file, 'a') as f:
                f.write(' '.join(map(str, new_tile_sizes)) + ' ' + printed_value + '\n')

print("Procedure completed for " + str(iterations_count) + " iterations.")