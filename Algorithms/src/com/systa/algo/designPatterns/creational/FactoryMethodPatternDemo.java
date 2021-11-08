/**
 * 
 */
package com.systa.algo.designPatterns.creational;

/**
 * @author mohsin
 * 
 * the factory method is defined as providing an interface for object creation but delegating the actual instantiation of objects to subclasses.
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

class MadameImplementation implements CustomerInformationSystem{
	
	@Override
	public Response makeCallToCIS(Request request) {
		// make call to CIS via WB
		return new Response("9999");
	}
}

class CISImplementationFactory {
	
	public static CustomerInformationSystem getImplementationClass(String type) {
		if(type.equalsIgnoreCase("WB")) {
			return new WBImplementation();
		}
		else if (type.equals("MADAMME")) {
			return new MadameImplementation();
		}
		return null;
	}
}

public class FactoryMethodPatternDemo {

	public static void main(String args[]) {
		CustomerInformationSystem system = CISImplementationFactory.getImplementationClass("WB");
		System.out.println(system.makeCallToCIS(new Request()));
		
		CustomerInformationSystem system1 = CISImplementationFactory.getImplementationClass("MADAMME");
		System.out.println(system1.makeCallToCIS(new Request()));
	}
	
}
