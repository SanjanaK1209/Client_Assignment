package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    
    @OneToMany(mappedBy = "customer")
    private List<CustomerTransaction> transactions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CustomerTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<CustomerTransaction> transactions) {
		this.transactions = transactions;
	}

	public Customer(Long id, String name, String email, String password, List<CustomerTransaction> transactions) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.transactions = transactions;
	}

    
}
