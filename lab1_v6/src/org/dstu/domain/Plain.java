package org.dstu.domain;

public class Plain extends PassengerTransport{
    public Integer stewardessNumber;
    public Integer maxHeight;
    public String company;

    public Plain(){}

    public Plain(String[] line){
        super(line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]));
        stewardessNumber = Integer.parseInt(line[4]);
        maxHeight = Integer.parseInt(line[5]);
        company = line[6];
    }

    public Integer getStewardessNumber() {
        return stewardessNumber;
    }

    public void setStewardessNumber(Integer stewardessNumber) {
        this.stewardessNumber = stewardessNumber;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Самолет: ");
        builder.append(super.toString());
        builder.append(" | Число стюардесс: ");
        builder.append(stewardessNumber);
        builder.append(" | Максимальная высота: ");
        builder.append(maxHeight);
        builder.append(" | Компания: ");
        builder.append(company);
        return builder.toString();
    }
}
