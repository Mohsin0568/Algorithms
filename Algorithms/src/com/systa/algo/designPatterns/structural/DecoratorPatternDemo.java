/**
 * 
 */
package com.systa.algo.designPatterns.structural;

/**
 * @author mohsin
 * 
 * A decoration is added to something to make it more attractive, in the same spirit, the decorator pattern adds new functionality to objects without modifying their defining classes.
 *
 */

class Request{
	private String requestNo;

	@Override
	public String toString() {
		return "Request [requestNo=" + requestNo + "]";
	}
}

class Response{
	
	private String responseCode;
	Response(String responseCode){
		this.responseCode = responseCode;
	}
	
	@Override
	public String toString() {
		return "Response [responseCode=" + responseCode + "]";
	}	
}

interface CustomerInformationSystem{
	Response makeCallToCIS(Request request);
}

class WBImplementation implements CustomerInformationSystem{

	@Override
	public Response makeCallToCIS(Request request) {
		// make call to CIS via WB
		return new Response("0000");
	}	
}

/**
 * This is a decorator class, instead of calling WBImplementation class we can call this class which will additionally log request response object along with making wb call.
 */
class WBImplementationWithLogs{
	CustomerInformationSystem cis;
	
	WBImplementationWithLogs(CustomerInformationSystem cis){
		this.cis = cis;
	}
	
	public Response makeCallToCIS(Request request) {
		logRequest(request);
		Response response = cis.makeCallToCIS(request);
		logResponse(response);
		return response;
	}
	
	private void logRequest(Request request) {
		// log object in any source which ever you like
	}
	
	private void logResponse(Response response) {
		// log object in any source which ever you like
	}
	
}

public class DecoratorPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WBImplementationWithLogs system = new WBImplementationWithLogs(new WBImplementation());
		system.makeCallToCIS(new Request());
	}
}
