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

public class PayEntryVisitor extends SimpleAnnotationValueVisitor7<Void, Void> {


    private Filer mFiler;
    private TypeMirror mTypeMirror;
    private String mPackage;

    PayEntryVisitor(Filer mFiler) {
        this.mFiler = mFiler;
    }


    @Override
    public Void visitString(String s, Void aVoid) {

        mPackage = s;
        return aVoid;
    }

    @Override
    public Void visitType(TypeMirror t, Void aVoid) {

        generateJavaCode(t);
        return aVoid;
    }

    private void generateJavaCode(TypeMirror typeMirror) {

        final TypeSpec targetActivity = TypeSpec.classBuilder("WXPayEntryActivity")
                .addModifiers(Modifier.PUBLIC)
                .addModifiers(Modifier.FINAL)
                .superclass(TypeName.get(typeMirror))
                .build();
        final JavaFile javaFile = JavaFile.builder(mPackage + "mwxapi", targetActivity)
                .addFileComment("微信支付入口文件")
                .build();

        try {
            javaFile.writeTo(mFiler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
