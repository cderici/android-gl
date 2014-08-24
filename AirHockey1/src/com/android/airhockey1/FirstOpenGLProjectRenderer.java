package com.android.airhockey1;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import static android.opengl.GLES20.GL_COLOR_BUFFER_BIT;
import static android.opengl.GLES20.glClear;
import static android.opengl.GLES20.glClearColor;
import static android.opengl.GLES20.glViewport;

public class FirstOpenGLProjectRenderer implements Renderer{

	@Override
	public void onDrawFrame(GL10 glUnused) {
		// TODO Auto-generated method stub
		glClear(GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void onSurfaceChanged(GL10 glUnused, int width, int height) {
		// TODO Auto-generated method stub
		glViewport(0, 0, width, height);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		glClearColor(15.0f, 0.0f, 0.0f, 0.0f);
	}
}