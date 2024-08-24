package org.example;


import java.util.*;

/**
 * Реализация структуры данных "Динамический массив".
 *
 * @param <T> тип элементов, хранящихся в списке
 */
public class MyArrayList<T> implements List<T> {

    private int initialCapacity;// Начальная емкость массива
    private T[] array;// Массив для хранения элементов
    private int size;// Текущий размер списка
    private int counter;

    /**
     * Конструктор, который создает новый экземпляр MyArrayList с начальной емкостью 10.
     */
    public MyArrayList() {
        this.initialCapacity = 10;
        this.array = (T[]) new Object[initialCapacity];
        this.size = size;
        this.counter = counter;

    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуст ли список.
     *
     * @return true, если список пуст; иначе false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Проверяет, содержится ли указанный элемент в списке.
     *
     * @param o элемент, который нужно проверить
     * @return true, если элемент содержится в списке; иначе false
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает итератор для перебора элементов списка.
     *
     * @return итератор для списка
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * Возвращает массив, содержащий все элементы списка.
     *
     * @return массив с элементами списка
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    /**
     * Возвращает массив, содержащий все элементы списка.
     * Если указанный массив недостаточно велик, создается новый массив с той же
     * емкостью, что и размер текущего списка.
     *
     * @param a массив, в который будут помещены элементы списка
     * @return массив с элементами списка
     */
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    /**
     * Добавляет указанный элемент в конец списка.
     *
     * @param t элемент, который нужно добавить
     * @return true, так как добавление элемента всегда успешно
     */
    @Override
    public boolean add(T t) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = t;
        return true;
    }

    /**
     * Удаляет первое вхождение указанного элемента из списка, если он есть.
     *
     * @param o элемент, который нужно удалить
     * @return true, если элемент был удален; иначе false
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Проверяет, содержатся ли все элементы из указанной коллекции в списке.
     *
     * @param c коллекция, которую нужно проверить
     * @return true, если список содержит все элементы из коллекции; иначе false
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    /**
     * Добавляет все элементы из указанной коллекции в конец списка.
     *
     * @param c коллекция, элементы которой нужно добавить
     * @return true, если список был изменён в результате вызова метода; иначе false
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    /**
     * Добавляет все элементы из указанной коллекции, начиная с указанной позиции в списке.
     *
     * @param index индекс, с которого нужно начать добавление
     * @param c коллекция, элементы которой нужно добавить
     * @return true, если список был изменён в результате вызова метода; иначе false
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    /**
     * Удаляет из списка все элементы, которые содержатся в указанной коллекции.
     *
     * @param c коллекция, элементы которой нужно удалить
     * @return true, если список был изменён в результате вызова метода; иначе false
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Удаляет из списка все элементы, которые не содержатся в указанной коллекции.
     *
     * @param c коллекция, элементы которой нужно сохранить
     * @return true, если список был изменён в результате вызова метода; иначе false
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Сортирует элементы списка в естественном порядке или с использованием указанного компаратора.
     *
     * @param c компаратор, который будет использован для сортировки
     */
    @Override
    public void sort(Comparator<? super T> c) {
//        List.super.sort(c);
        mergeSort((T[]) array, 0, counter - 1, c);
    }
    private void mergeSort(T[] array, int left, int right, Comparator<? super T> c) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid, c);
            mergeSort(array, mid + 1, right, c);

            merge(array, left, mid, right, c);
        }
    }

    private void merge(T[] array, int left, int mid, int right, Comparator<? super T> c) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] leftArray = (T[]) new Object[n1];
        T[] rightArray = (T[]) new Object[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (c.compare(leftArray[i], rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
    /**
     * Удаляет все элементы из списка.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * Возвращает элемент, находящийся по указанному индексу.
     *
     * @param index индекс элемента
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс вне диапазона
     */
    @Override
    public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            return array[index];
        }

    /**
     * Устанавливает указанный элемент по указанному индексу и возвращает старый элемент.
     *
     * @param index индекс элемента
     * @param element новый элемент, который нужно установить
     * @return старый элемент, находившийся по указанному индексу
     * @throws IndexOutOfBoundsException если индекс вне диапазона
     */
    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    /**
     * Вставляет указанный элемент по указанному индексу.
     *
     * @param index индекс, по которому нужно вставить элемент
     * @param element элемент, который нужно вставить
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;

        }


    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }

}



