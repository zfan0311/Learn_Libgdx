package MyPkgs;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
//���봦��ͼƬ�Ŀ��ļ�
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//���봦����������Ŀ��ļ�
import com.badlogic.gdx.graphics.g2d.TextureRegion;
//���봦������Ŀ��ļ�
import com.badlogic.gdx.graphics.g2d.Sprite;


public class MainGame implements ApplicationListener {
	// ����Ļ���
	private SpriteBatch batch;
	// ����
	private Texture texture;
	// ��������
	private TextureRegion region;
	// ������
	private Sprite bg, bird;

	@Override
	// ����Ϸ����ʱִ��һ��
	public void create() {
		//��������������
		batch = new SpriteBatch();
		texture = new Texture("atlas.png");
		region = new TextureRegion(texture, 0, 0, 290, 480);
		bg = new Sprite(region);
		region = new TextureRegion(texture, 0, 974, 50, 50);
		bird = new Sprite(region);
		bg.setPosition(15*320/290, 0);
		bg.setScale(320/290F,1F);
		bird.setPosition(100,  200);
		Gdx.app.log("Texture Width", texture.getWidth() + "px");
		Gdx.app.log("Texture Height", texture.getHeight() + "px");
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void resume() {
	}

	@Override
	public void pause() {
	}

	@Override
	// ����Ϸ���й����в����ظ�����
	public void render() {
		bird.translateX(10*Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(1, 0, 0, 1);

		// ����
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// ����������
		batch.begin();
		bg.draw(batch);
		bird.draw(batch);
		batch.end();
	}

	@Override
	// �ر���Ϸʱ������һ��
	public void dispose() {
		// ���ٻ���,�ͷſռ�
		if (batch != null) {
			batch.dispose();
		}
		if (texture != null) {
			texture.dispose();
		}
	}
}