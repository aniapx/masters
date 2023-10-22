// gcc comparator.c app1.c app2.c -lm && ./a.out

#include <stdio.h>
#include <stdlib.h>
#include "app1.h"
#include "app2.h"

int main(void) {
   printf("App1: Start");
   runApp1();
   printf("\nApp 1: Done\n\n");

   printf("App 2: Start");
   runApp2();
   printf("\nApp 2: Done\n");
   return 0;
}