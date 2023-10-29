import datetime
from time import perf_counter
import time
from time import sleep
import winsound
import os
from PIL import Image
def clear(): return os.system('cls')  # lambda to clear screen


time = 30


def runTasks():
    i = 0
    file = open("./events.txt", 'w')
    file.write("latency, timeStamp, type\n")
    tasks = (["zamkniete oczy", "otwarte oczy normalne mruganie", "otwarte oczy bez mrugania", "szybkie mruganie", "zaciskanie szczek, normalne mruganie",
             "ruchy oczu w prawo i w lewo", "mowienie, normalne mruganie", "ruchy glowy bez mrugania", "relaks przy muzyce", "zadanie aktywizujace"])
    tic = perf_counter()
    for task in tasks:
        i += 1
        if (i < 9):
            print(task)
            sleep(time)
        else:
            print(task)
            if (i == 90):
                winsound.PlaySound('music.wav', winsound.SND_FILENAME)
            if (i == 10):
                img = Image.open("task.jpg")
                img.show()
                sleep(time*2)
                img.close()
        toc = perf_counter()
        winsound.Beep(500, 300)
        current_time = datetime.datetime.now()
        file.write(
            f"{toc - tic:0.4f} seconds, {str(int(current_time.timestamp())*1000)}, {task}\n")
        clear()


# main
runTasks()
