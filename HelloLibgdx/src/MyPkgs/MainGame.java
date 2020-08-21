package MyPkgs;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
//引入处理图片的库文件
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//引入处理纹理区域的库文件
import com.badlogic.gdx.graphics.g2d.TextureRegion;
//引入处理精灵类的库文件
import com.badlogic.gdx.graphics.g2d.Sprite;


public class MainGame implements ApplicationListener {
	// 纹理的画布
	private SpriteBatch batch;
	// 纹理
	private Texture texture;
	// 纹理区域
	private TextureRegion region;
	// 精灵类
	private Sprite bg, bird;

	@Override
	// 在游戏创建时执行一次
	public void create() {
		//创建画布和纹理
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
	// 在游戏运行过程中不断重复调用
	public void render() {
		bird.translateX(10*Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(1, 0, 0, 1);

		// 清屏
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// 绘制纹理画布
		batch.begin();
		bg.draw(batch);
		bird.draw(batch);
		batch.end();
	}

	@Override
	// 关闭游戏时被调用一次
	public void dispose() {
		// 销毁画布,释放空间
		if (batch != null) {
			batch.dispose();
		}
		if (texture != null) {
			texture.dispose();
		}
	}
}