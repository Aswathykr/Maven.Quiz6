package rocks.zipcode.io.objectorientation;

public class Television {
    private TVChannel channel;
    private boolean isTurnedOn = false;
    public void turnOn() {
        isTurnedOn = true;
    }

    public void setChannel(Integer channel) {
        if(!isTurnedOn)
            throw new IllegalStateException();
        this.channel = TVChannel.getByOrdinal(channel);
    }

    public TVChannel getChannel() {
        return channel;
    }
}
