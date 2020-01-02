#include <stdio.h>

#define a (x+1)

int x = 2;
void b() {
  x = a;
  printf("%d\n", x);  // 3
}
void c() {
  int x = 1;
  printf("%d\n", a);  // 2
}

void main() {
  b();
  c();
}
