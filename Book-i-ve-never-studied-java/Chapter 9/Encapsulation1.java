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

class ColdPatient
{
	public void takeSinivelCap(SinivelCap cap){cap.take();}
	public void takeSneezeCap(SneezeCap cap){cap.take();}
	public void takeSnuffleCap(SnuffleCap cap){cap.take();}
}

class Encapsulation1
{
	public static void main(String[] args)
	{
		ColdPatient sufferer = new ColdPatient();
		sufferer.takeSinivelCap(new SinivelCap());
		sufferer.takeSneezeCap(new SneezeCap());
		sufferer.takeSnuffleCap(new SnuffleCap());
	}
}