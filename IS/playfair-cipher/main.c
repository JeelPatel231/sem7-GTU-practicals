#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 5
#define M 5
int PF_MATRIX[N][M] = {0};

// n = rows, m = columns
// int **allocate_matrix(int m, int n) {
//   int **array = malloc(n * sizeof *array + (n * (m * sizeof **array)));
//   return array;
// }

char *create_abc() {
  char *array_ptr = malloc(sizeof(char) * 26);
  for (int i = 97; i < 123; i++) {
    array_ptr[i - 97] = i;
  }
  array_ptr[9] = '-';
  return array_ptr;
}

void assign_key(char *key) {
  char *abc = create_abc();
  int key_len = strlen(key);
  for (int i = 0; i < key_len; i++) {
    abc[key[i] - 97] = '-';
  }
  for (int i = 0; i < key_len; i++) {
    PF_MATRIX[i / 5][i % 5] = key[i];
  }

  //
}

int main(void) {
  char key[] = "monarchy";

  assign_key(key);

  for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
      printf("%c", PF_MATRIX[i][j]); // = key[i + j];
    }
    printf("\n");
  }

  return 0;
}
