#inclue <stdio.h>

int main() {
  int w, x, y, z; /* 块 B1 */
  {
    int x, z;   /* 块 B2 */
    {  int w, x;  /* 块 B3 */}
  }
  {
    int w, x; /* 块 B4 */
    {  int y, z;  /* 块 B5 */}
  }
  return 0;
}
