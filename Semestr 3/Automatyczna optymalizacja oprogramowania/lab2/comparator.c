//gcc comparator.c app1.c app2.c -lm

#include <stdio.h>
#include <stdlib.h>
#include "app1.h"
#include "app2.h"

int main(void) {
   printf("Start\n");
   runApp1();
   printf("App 1: okay\n");
   // runApp2();
   printf("App 2: okay\n");
   return 0;
}