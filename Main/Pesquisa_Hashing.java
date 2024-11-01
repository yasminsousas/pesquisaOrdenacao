package Main;

import dados.HashEntry;
import java.util.LinkedList;

public class Pesquisa_Hashing {

    class HashTable {
        private LinkedList<HashEntry>[] table;
        private int size;

        @SuppressWarnings("unchecked")
        public HashTable(int size) {
            this.size = size;
            table = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                table[i] = new LinkedList<>();
            }
        }

        private int hash(int key) {
            return Integer.hashCode(key) % size;
        }

        public void put(int key) {
            int index = hash(key);
            LinkedList<HashEntry> bucket = table[index];

            // Verifica se a chave já existe
            for (HashEntry entry : bucket) {
                if (entry.key == key) {
                    return; // Não adiciona duplicatas
                }
            }

            bucket.add(new HashEntry(key)); // Adiciona nova entrada
        }

        public boolean get(int key) {
            int index = hash(key);
            LinkedList<HashEntry> bucket = table[index];

            for (HashEntry entry : bucket) {
                if (entry.key == key) {
                    return true; // Retorna verdadeiro se a chave for encontrada
                }
            }
            return false; // Retorna falso se a chave não for encontrada
        }

        public void remove(int key) {
            int index = hash(key);
            LinkedList<HashEntry> bucket = table[index];

            bucket.removeIf(entry -> entry.key == key); // Remove a entrada se a chave for encontrada
        }
    }
}
