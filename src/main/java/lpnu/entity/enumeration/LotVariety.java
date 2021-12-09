package lpnu.entity.enumeration;

public enum LotVariety {
    COMMONER (1),
    ELITE (2),
    VIP (3);

    private int typeOfLot;

    LotVariety(int typeOfLot) {
        this.typeOfLot = typeOfLot;
    }

    public int getTypeOfLot() {
        return typeOfLot;
    }
}
