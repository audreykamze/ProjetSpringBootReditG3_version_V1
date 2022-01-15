package org.formation.entity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.hibernate.annotations.GenericGenerator;

@Entity
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(
			name="native",
			strategy = "native"
			)
	
	private Integer id;
	private String title;
	private String link;
	private int votes;



	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Article(Integer id, String title, String link, int vote) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.votes = vote;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public int getVote() {
		return votes;
	}



	public void setVote(int vote) {
		this.votes = vote;
	}



	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", link=" + link + ", vote=" + votes + "]";
	}


	

	

}
