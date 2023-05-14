package org.dstu.domain;

public class Ship extends PassengerTransport{
    private Integer length;
    private String captainName;
    private Integer maxSpeed;

    public Ship(){}

    public Ship(String[] line){
        super(line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]));
        length = Integer.parseInt(line[4]);
        captainName = line[5];
        maxSpeed = Integer.parseInt(line[6]);
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Корабль: ");
        builder.append(super.toString());
        builder.append(" | Длина: ");
        builder.append(length);
        builder.append(" | Капитан: ");
        builder.append(captainName);
        builder.append(" | Максимальная скорость: ");
        builder.append(maxSpeed);
        return builder.toString();
    }
}
