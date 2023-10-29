import datetime
from time import perf_counter
import time
from time import sleep
from pygame import mixer
import os
from PIL import Image
def clear(): return os.system('cls')  # lambda to clear screen


time = 1


def runTasks():
    i = 0
    file = open("./events.txt", 'w')
    file.write("latency, timeStamp, type\n")
    tasks = (["zamkniete oczy", "otwarte oczy normalne mruganie", "otwarte oczy bez mrugania", "szybkie mruganie", "zaciskanie szczek, normalne mruganie",
             "ruchy oczu w prawo i w lewo", "mowienie, normalne mruganie", "ruchy glowy bez mrugania", "relaks przy muzyce", "zadanie aktywizujace"])
    tic = perf_counter()
    for task in tasks:
        i += 1
        toc = perf_counter()
        current_time = datetime.datetime.now()
        file.write(
            f"{toc - tic:0.4f} seconds, {str(int(current_time.timestamp())*1000)}, {task}\n")
        if (i < 9):
            print(task)
            sleep(time)
        else:
            print(task)
            if (i == 9):
                music.play()
            if (i == 10):
                img.show()
            sleep(time * 2)
        sound.play()
        clear()

# main
mixer.init()  # Initialzing pygame mixer
sound = mixer.Sound('sound.wav')  # sound for ends
music = mixer.Sound('music.wav')  # music for one task
img = Image.open("find_the_difference.jpg")
runTasks()
