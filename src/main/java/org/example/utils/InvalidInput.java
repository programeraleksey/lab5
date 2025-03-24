package org.example.utils;

/**
 * Класс-исключение для облегченного вывода ошибок.
 */
public class InvalidInput extends Exception {
  public InvalidInput(String message) {
    super(message);
  }

  /**
   * @return Строка для красивого вывода ошибки.
   */
  public String printExc() {
    return "Ошибка. " + this.getMessage() + " Повторите попытку.";
  }
}
