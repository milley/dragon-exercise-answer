#include <stdio.h>

int main() {
  int w, x, y, z;
  int i = 3;
  int j = 4;
  {
    int i = 5;
    w = i + j;
    printf("%d\n", w);  // 9
  }
  x = i + j;
  printf("%d\n", x);  // 7
  {
    int j = 6;
    i = 7;
    y = i + j;
    printf("%d\n", y);  // 13
  }
  z = i + j;
  printf("%d\n", z);   // 11
  return 0;
}
