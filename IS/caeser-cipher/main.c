#include <stdio.h>
#include <string.h>

void encrypt_text(char *plain_text, int key) {
  int length = strlen(plain_text);
  for (int i = 0; i < length; i++) {
    plain_text[i] = ((plain_text[i] - 97 + key) % 26) + 97;
  }
}

void decrypt_text(char *plain_text, int key) {
  int length = strlen(plain_text);
  for (int i = 0; i < length; i++) {
    plain_text[i] = ((plain_text[i] - 97 - key) % 26) + 97;
  }
}

int main(void) {
  char plain_text[] = "alphabet";
  printf("plaintext : %s\n", plain_text);
  encrypt_text(plain_text, 3);
  printf("encrypted : %s\n", plain_text);
  decrypt_text(plain_text, 3);
  printf("decrypted : %s\n", plain_text);
  return 0;
}
