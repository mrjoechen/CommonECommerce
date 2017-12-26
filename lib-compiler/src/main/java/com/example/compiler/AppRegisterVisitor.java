package com.example.compiler;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;

/**
 * Created by CHENQIAO on 2017/12/26.
 */

public class AppRegisterVisitor extends SimpleAnnotationValueVisitor7<Void, Void> {


    private Filer mFiler;
    private TypeMirror mTypeMirror;
    private String mPackage;

    AppRegisterVisitor(Filer mFiler) {
        this.mFiler = mFiler;
    }


    @Override
    public Void visitString(String s, Void aVoid) {

        mPackage = s;
        return aVoid;
    }

    @Override
    public Void visitType(TypeMirror t, Void aVoid) {

        mTypeMirror = t;
        return aVoid;
    }

    private void generateJavaCode() {

        final TypeSpec targetActivity = TypeSpec.classBuilder("AppRegister")
                .addModifiers(Modifier.PUBLIC)
                .addModifiers(Modifier.FINAL)
                .superclass(TypeName.get(mTypeMirror))
                .build();
        final JavaFile javaFile = JavaFile.builder(mPackage + "mwxapi", targetActivity)
                .addFileComment("微信广播接收器")
                .build();

        try {
            javaFile.writeTo(mFiler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
