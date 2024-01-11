class SinivelCap   // Äà¹° Ã³Ä¡¿ë Ä¸½¶
{
	public void take(){System.out.println("Äà¹°ÀÌ ½Ï~ ³³´Ï´Ù.");}
}

class SneezeCap   // ÀçÃ¤±â Ã³Ä¡¿ë Ä¸½¶
{
	public void take() {System.out.println("ÀçÃ¤±â°¡ ¸Ü½À´Ï´Ù.");}
}

class SnuffleCap   // ÄÚ¸·Èû Ã³Ä¡¿ë Ä¸½¶
{
	public void take() {System.out.println("ÄÚ°¡ »½ ¶Õ¸³´Ï´Ù.");}
}

class CONTAC600 
{
	SinivelCap sin;
	SneezeCap sne;
	SnuffleCap snu;
	
	public CONTAC600()
	{
		sin=new SinivelCap();
		sne=new SneezeCap();
		snu=new SnuffleCap();
	}
	public void take()
	{
		sin.take();
		sne.take();
		snu.take();
	}
}

class ColdPatient
{
	public void takeCONTAC600(CONTAC600 cap){cap.take();}
}

class Encapsulation2
{
	public static void main(String args[])
	{
		ColdPatient sufferer = new ColdPatient();
		sufferer.takeCONTAC600(new CONTAC600());

	}
}