package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.example.demo.vo.Projeto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Named
public class HelloWorld {
	  
	  private List<Projeto> projetos = new ArrayList<Projeto>();
	  
	  Projeto projeto = new Projeto();

	  public Projeto getProjeto() {
			return projeto;
		}
		
		public void setProjeto(Projeto projeto) {
			this.projeto = projeto;
		}
		
	  public HelloWorld() {
		  
		  try {
			URL url = new URL ("http://localhost:8080/projetos");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			//String jsonInputString = "{"name": "Upendra", "job": "Programmer"}";
			try(BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream(), "utf-8"))) {
					StringBuilder response = new StringBuilder();
					String responseLine = null;
					while ((responseLine = br.readLine()) != null) {
						response.append(responseLine.trim());
					} 
					ObjectMapper mapper = new ObjectMapper();
					Projeto[] pp1 = mapper.readValue(response.toString(), Projeto[].class);
					for (Projeto projeto : pp1) {
						projetos.add(projeto);
		                System.out.println(projeto);
		            }
					//System.out.println(response.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
	  }

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	public void buttonAction() {
		try {
			URL url = new URL ("http://localhost:8080/projetos");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
		
			
			
			String jsonInputString = "{\"nome\": \""+projeto.getNome()+"\", \"empresa\":{ \"id\": "+projeto.getEmpresa().getId()+"}, \"data_ativacao\": \""+dt.format(projeto.getData_ativacao())+"\"}";
			
			
		        
		       // "data_ativacao": "2019-01-01T00:00:00",
		        
		  
			
			try(OutputStream os = con.getOutputStream()) {
			    byte[] input = jsonInputString.getBytes("utf-8");
			    os.write(input, 0, input.length);           
			}
			try(BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream(), "utf-8"))) {
					StringBuilder response = new StringBuilder();
					String responseLine = null;
					while ((responseLine = br.readLine()) != null) {
						response.append(responseLine.trim());
					} 
					
					System.out.println(response.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
