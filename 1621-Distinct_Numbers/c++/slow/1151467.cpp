#include <stdio.h>
#include <stdlib.h>
#include <stddef.h>
 
typedef unsigned int u32;
typedef unsigned long u64;
 
struct Entry {
    u64 value;
    Entry *next;
};
 
struct HashSet {
    size_t size;
    Entry **entries;
 
    HashSet(size_t size) : size(size) {
        entries = (Entry**) calloc(size, sizeof(Entry*));
    }
 
    void insert(u64 value) {
        u64 hash = value % this->size;
 
        Entry *last_entry = NULL;
        for (Entry *entry = entries[hash]; entry; entry = entry->next) {
            if (entry->value == value) {
                return;
            }
            last_entry = entry;
        }
 
        Entry *next = (Entry*) calloc(1, sizeof(Entry));
        next->value = value;
        next->next = NULL;
        if (last_entry) {
            last_entry->next = next;
        } else {
            entries[hash] = next;
        }
    }
 
    u64 count() {
        u64 total = 0;
        for (size_t i = 0; i < size; ++i) {
            for (Entry *e = entries[i]; e; e = e->next) {
                total++;
            }
        }
        return total;
    }
 
};
 
int main() {
    u32 count;
    scanf("%d", &count);
 
    HashSet hs(1023);
    for (u32 i = 0; i < count; ++i) {
        u64 num;
        scanf("%lu", &num);
        hs.insert(num);
    }
 
    printf("%lu\n", hs.count());
}