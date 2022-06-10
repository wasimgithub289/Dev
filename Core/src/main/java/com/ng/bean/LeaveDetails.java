package com.ng.bean;

public class LeaveDetails 
{
	private int leaveID;
	private String leaveType;
	private int leaveDays;
	
	public LeaveDetails(int leaveID, String leaveType, int leaveDays) {
		super();
		this.leaveID = leaveID;
		this.leaveType = leaveType;
		this.leaveDays = leaveDays;
	}

	public int getLeaveID() {
		return leaveID;
	}

	public void setLeaveID(int leaveID) {
		this.leaveID = leaveID;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public int getLeaveDays() {
		return leaveDays;
	}

	public void setLeaveDays(int leaveDays) {
		this.leaveDays = leaveDays;
	}

	@Override
	public String toString() {
		return "LeaveDetails [leaveID=" + leaveID + ", leaveType=" + leaveType + ", leaveDays=" + leaveDays + "]";
	}
}
