package OtherProjects.Lab03;

public class Store {
    DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[100];
    int count = 0;
    public void addDVD(DigitalVideoDisc disc) {
        if (count < 100) {
            itemsInStore[count] = disc;
            count++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The store is almost full");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                if (itemsInStore[i].getTitle().equals(disc.getTitle())) {
                    for (int j = i; j < count - 1; j++) {
                        itemsInStore[j] = itemsInStore[j + 1];
                    }
                    count--;
                    System.out.println("The disc has been removed");
                    return;
                }
            }
            System.out.println("The disc is not in the store");
        } else {
            System.out.println("The store is empty");
        }
    }
}
