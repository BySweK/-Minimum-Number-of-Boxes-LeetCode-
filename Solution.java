class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        // Toplam elma sayısını hesapla
        int toplamElma = 0;
        for (int i = 0; i < apple.length; i++) {
            toplamElma += apple[i];
        }

        // Kapasiteleri büyükten küçüğe sıralama (Bubble Sort)
        for (int i = 0; i < capacity.length - 1; i++) {
            for (int j = 0; j < capacity.length - 1 - i; j++) {
                if (capacity[j] < capacity[j + 1]) {
                    int temp = capacity[j];
                    capacity[j] = capacity[j + 1];
                    capacity[j + 1] = temp;
                }
            }
        }

        // En büyük kapasiteli kutulardan başlayarak elmayı yerleştir
        int adet = 0;
        for (int i = 0; i < capacity.length; i++) {
            toplamElma -= capacity[i];
            adet++;

            if (toplamElma <= 0) {
                break;
            }
        }

        return adet;
    }
}
