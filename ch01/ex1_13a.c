#include <stdio.h>

int main() {
  int w, x, y, z;
  int i = 4;
  int j = 5;
  {
    int j = 7;
    i = 6;
    w = i + j;
    printf("%d\n", w);  // 13
  }
  printf("i = %d, j = %d\n", i, j);
  x = i + j;
  printf("%d\n", x);  // 11 
  {
    int i = 8;
    y = i + j;
    printf("%d\n", y);  // 13
  }
  printf("i = %d, j = %d\n", i, j);
  z = i + j;
  printf("%d\n", z);  // 11
  return 0;
}

/*
13
i = 6, j = 5
11
13
i = 6, j = 5
11
*/
