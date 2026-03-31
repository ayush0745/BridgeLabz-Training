import java.util.Random;

class FileDownloader implements Runnable {
	String fileName;
	Random random = new Random();

	public FileDownloader(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 100; i += 10) {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " downloading " + fileName + ": " + i + "%");
			try {
				Thread.sleep(200 + random.nextInt(500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class DownloadManager {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new FileDownloader("Document.pdf"));
		Thread t2 = new Thread(new FileDownloader("Image.jpg"));
		Thread t3 = new Thread(new FileDownloader("Video.mp4"));

		t1.setName("Thread 1");
		t2.setName("Thread 2");
		t3.setName("Thread 3");

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		System.out.println("All downloads complete!");
	}

}