package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import granguil.data.annotation.NotSend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Code
 *
 */
@Entity
@JsonInclude(Include.NON_NULL)
@Table(name="code_element")
public class Code implements Serializable {

	@NotSend
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID code;
	
	@Column(name="table_name")
	@NotSend
	private String tableName;

	@OneToOne(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	private AssociatedCode associatedElement;

	@OneToOne(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Solution solution;
	
	@OneToOne(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Task task;
	
	@OneToOne(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Idea idea;
	
	@OneToOne(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Process process;
	
	@OneToOne(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Event event;
	
	@OneToOne(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Project project;
	
	@OneToOne(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Calendar calendar;
	
	@OneToOne(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Environment environment;
	
	public Code() {
		super();
	}

	public UUID getCode() {
		return code;
	}

	public void setCode(UUID code) {
		this.code = code;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public AssociatedCode getAssociatedElement() {
		return associatedElement;
	}

	public void setAssociatedElement(AssociatedCode associatedElement) {
		this.associatedElement = associatedElement;
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
 
	
}
