package org.dstu.domain;

public abstract class PassengerTransport implements ITransport {
    private String name;
    private Integer maxPassengers;
    private Integer maxBags;

    public PassengerTransport() {
    }

    public PassengerTransport(String name, Integer maxPassengers, Integer maxBags) {
        this.name = name;
        this.maxPassengers = maxPassengers;
        this.maxBags = maxBags;
    }

    public PassengerTransport(String[] line) {
        name = line[1];
        maxPassengers = Integer.parseInt(line[2]);
        maxBags = Integer.parseInt(line[3]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(Integer maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public Integer getMaxBags() {
        return maxBags;
    }

    public void setMaxBags(Integer maxBags) {
        this.maxBags = maxBags;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Название: ");
        builder.append(name);
        builder.append(" | Максмум пассажиров: ");
        builder.append(maxPassengers);
        builder.append(" | Максимум багажа: ");
        builder.append(maxBags);
        return builder.toString();
    }
}
