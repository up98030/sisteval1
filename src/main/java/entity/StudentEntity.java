package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class StudentEntity {

        @Id
        @Column(name = "ID")
        private int id;
        
        @Column(name = "NAME")
        private String name;
        
        @Column(name = "DEPARTMENT")
        private String department;
        
        @Column(name = "COLLEGE")
        private String college;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getCollege() {
			return college;
		}

		public void setCollege(String college) {
			this.college = college;
		}
        
}