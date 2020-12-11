package Entity;



import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author gar4a
 */
public class Category {
    private int id;
    private String title;
    private List <usedbook> lb = new ArrayList<usedbook>();

  
    public Category( String title) {
        super();
        this.title = title;
    }
    

    public Category() {
		super();
	}


	public Category(int id) {
		super();
		this.id = id;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<usedbook> getLb() {
        return lb;
    }

    public void setLb(List<usedbook> lb) {
        this.lb = lb;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", title=" + title + ", lb=" + lb + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }
    
    
}
