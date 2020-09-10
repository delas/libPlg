package plg.model.data;

import java.util.Set;

/**
 * This interface models the possible owners of data objects.
 * 
 * @author Andrea Burattin
 */
public interface IDataObjectOwner {

	/**
	 * This enumeration specifies whether the data object is required by an
	 * activity or whether it is generated by the activity
	 */
	public enum DATA_OBJECT_DIRECTION {
		REQUIRED, GENERATED
	}

	/**
	 * This method returns the id of the current object owner
	 * 
	 * @return the id of the current owner
	 */
	public String getId();
	
	/**
	 * This method to add a new data object to the current flow object
	 * 
	 * @param data the data object to be added to the current flow object
	 * @param direction the "direction" of the data object
	 */
	public void addDataObject(DataObject data, DATA_OBJECT_DIRECTION direction);
	
	/**
	 * This method to remove the given data object from the current flow object
	 * 
	 * @param data the data object to be removed from the current flow object
	 */
	public void removeDataObject(DataObject data);
	
	/**
	 * This method returns the set of all the data objects associated to the
	 * current data object owner
	 * 
	 * @return the set of data objects
	 */
	public Set<DataObject> getDataObjects();
	
	/**
	 * This method returns the set of all the data objects associated to the
	 * current data object owner
	 * 
	 * @param direction the direction of the data objects to retrieve
	 * @return the set of data objects
	 */
	public Set<DataObject> getDataObjects(DATA_OBJECT_DIRECTION direction);
}
