package MyPkgs;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {

	public static void main(String[] args) {

		// Ӧ������
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 320;			// ָ�����ڿ��
		config.height = 480;		// ָ�����ڸ߶�

		config.resizable = false;	// ��������Ϊ��С���ɸı�

		// ������Ϸ��������������� MainGame ����, �������� config, ������Ϸ����
		new LwjglApplication(new MainGame(), config);
	}
}