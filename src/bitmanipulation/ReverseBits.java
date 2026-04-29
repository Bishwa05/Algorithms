package bitmanipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        return rev(n, 32);
    }

    private int rev(int v, int len) {
        if (len == 1) return v & 1;

        int half = len >> 1;        // Example (len = 8): half = 4
        int mask = (1 << half) -1;  // mask = 00001111
        int lo = v & mask;          // v = 11010010 -> lo = 0010
        int hi = v >>> half;        // v = 11010010 -> hi = 1101

        int rlo = rev(lo, half);   // rev(0010) -> 0100
        int rhi = rev(hi, half);   // rev(1101) -> 1011

        return (rlo << half) | rhi;   // (0100 << 4) | 1011 = 01001011
    }

    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        System.out.println(r.reverseBits(43261596));
    }
}
