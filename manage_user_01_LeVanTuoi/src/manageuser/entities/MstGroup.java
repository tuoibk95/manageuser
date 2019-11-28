/**
 * Copyright(C) 2019 [Luvina Software Company]
 * MstGroup.java Nov 19, 2019 TuoiLV
 */
package manageuser.entities;

/**
 * Lớp thực thể của bảng mstGroup
 * @author TuoiLV	
 */
public class MstGroup {
	// Mã nhóm
	public int groupId;
	// Tên nhóm
	public String groupName;
	/**
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
