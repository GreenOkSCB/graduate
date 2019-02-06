package model.timepoint;

import model.util.Point;

import java.util.Date;

public class TimePoint implements Point {
    private double bid;
    private double ask;
    private int qAsk;
    private int qBid;
    private double lastTrade;
    private Date timeLastTrade;
    private Date timeLastChange;
    private int openInterest;

    public TimePoint(double ask, double bid, int qAsk, int qBid, double lastTrade, Date timeLastTrade, Date timeLastChange, int openInterest) {
        this.bid = bid;
        this.ask = ask;
        this.qAsk = qAsk;
        this.qBid = qBid;
        this.lastTrade = lastTrade;
        this.timeLastTrade = timeLastTrade;
        this.timeLastChange = timeLastChange;
        this.openInterest = openInterest;
    }

    public Date getTimeLastChange() {
        return timeLastChange;
    }

    @Override
    public Date getTime() {
        return getTimeLastChange();
    }

}
