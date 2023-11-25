import sys

# Функція для закриття файлу та виходу з програми
def close_program(fout):
    fout.flush()  # Запис в файл перед закриттям
    fout.close()  # Закриття файлу
    sys.exit(0)  # Завершення програму з кодом виходу 0 (без помилок)
def matrix():  # Головна функція програми
    n = int(input("Set the size of square matrix: "))
    lst = [[' ' for _ in range(n)] for _ in range(n)]
    filler = input("Set filler symbol: ")
    data_file = open("Matrix.txt", "w")  # Відкриття файл для запису

    data_file.write("Size of matrix:" + str(n))  # Запис розміру матриці у файл
    data_file.write("\nFiller symbol: " + filler)       # Запис символу-заповнювачу у файл

    if len(filler) > 1:  # Перевірка на кількість введених символів
        print("\nInputed more than 1 symbol!\nEnd of the program.")
        data_file.write("\nВи ввели більше ніж один символ!\nЗавершення програми.")
        close_program(data_file)  # Виклик функції для закриття файлу та виходу

    if not filler:  # Перевірка чи був введений символ
        print("\nNo filler symbol!\nNo filler symbol!")
        data_file.write("\nNo filler symbol!\nNo filler symbol!")
        close_program(data_file)  # Виклик функції для закриття файлу та виходу

    print("\n")
    data_file.write("\n")

    # Генерація зубчастого список
    for i in range(n):
        for j in range(n):
            if (i + 1) * 2 < n:
                lst[i] = [' ' for _ in range((i + 1) * 2)]
            elif (i + 1) * 2 > n + 2:
                lst[i] = [' ' for _ in range((n - i) * 2)]

    # Вивід зубчастого масиву
    for i in range(n):
        for j in range(n):
            num = 0
            if (len(lst[i]) // 2 > j) or (n // 2 == i) or ((len(lst[i]) // 2 + j >= n)):
                lst[i][num] = filler[0]
                print(lst[i][num] + "  ", end="")
                data_file.write(lst[i][num] + "  ")
                num += 1
            else:
                print("   ", end="")
                data_file.write("   ")
        print("\n")
        data_file.write("\n")

    data_file.close()  # Закриття файлу після завершення запису

if __name__ == "__main__":
    matrix()