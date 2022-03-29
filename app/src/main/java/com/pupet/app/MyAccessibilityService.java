package com.pupet.app;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;

import androidx.annotation.NonNull;



/**
 * Created by sotsys-014 on 4/10/16.
 */

@TargetApi(Build.VERSION_CODES.DONUT)
public class MyAccessibilityService extends AccessibilityService {
    private final AccessibilityServiceInfo info = new AccessibilityServiceInfo();
    private static final String TAG = "MyAccessibilityService";
    private static final String TAGEVENTS = "TAGEVENTS";
    private String currntApplicationPackage = "";

//    private WindowPositionController windowController;
    private WindowManager windowManager;
    private boolean showWindow = false;

    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        Log.d("Hello", "code: "+keyCode);
        Log.d("Hello", "act: "+action);

        return super.onKeyEvent(event);
    }

    @Override
    public Object getSystemService(@NonNull String name) {
        Log.d("Hello", name);
        return super.getSystemService(name);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        final String sourcePackageName = (String) accessibilityEvent.getPackageName();
        currntApplicationPackage = sourcePackageName;
        Log.d(TAG, "sourcePackageName:" + sourcePackageName);
        Log.d(TAG, "parcelable:" + accessibilityEvent.getText().toString());
        Log.d(TAG, "class:" + accessibilityEvent.getClassName());
        if(sourcePackageName.equals("com.bca")){

            if(accessibilityEvent.getClassName().equals("android.widget.FrameLayout")){
//                goToRegisterDestinationAccountPage(accessibilityEvent);
//                goToTransferPage(accessibilityEvent);
//                pressMbankingLoginBtn(accessibilityEvent);
                if(accessibilityEvent.getText()!=null&&accessibilityEvent.getText().toString().equals("[Kode Akses, Input 6 alphanum]")){
                    Bundle arguments = new Bundle();
                }
            }

            if(accessibilityEvent.getClassName().equals("o.AssistInvalidContentTypeException")){
//                enterAcessCode(accessibilityEvent);
                if(accessibilityEvent.getText()!=null&&accessibilityEvent.getText().toString().equals("[Kode Akses, Input 6 alphanum]")){
                    Bundle arguments = new Bundle();
                }
            }
        }

        if(accessibilityEvent.getClassName().equals("android.inputmethodservice.SoftInputWindow")){
            if(accessibilityEvent.getText()!=null&&accessibilityEvent.getText().toString().equals("[Kode Akses, Input 6 alphanum]")){
                Bundle arguments = new Bundle();
            }
        }

    }


    private void goToRegisterDestinationAccountPage(AccessibilityEvent accessibilityEvent){
        try {
            accessibilityEvent.getSource().getChild(0).getChild(1).getChild(0).getChild(0).getChild(1).getChild(3).getChild(0).getChild(1).performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }catch (Exception e){ }
    }
    private void pressMbankingLoginBtn(AccessibilityEvent accessibilityEvent){
        try {
            accessibilityEvent.getSource().getChild(0).getChild(0).getChild(0).getChild(0).getChild(0).getChild(2).performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }catch (Exception e){ }
    }

    private void goToTransferPage(AccessibilityEvent accessibilityEvent){
        try {
            if(accessibilityEvent.getSource().getChild(0).getChild(1).getChild(0).getChild(0).getChild(0).getChild(2).getChild(1).getChild(1).getText().toString().equals("m-Transfer")){
                accessibilityEvent.getSource().getChild(0).getChild(1).getChild(0).getChild(0).getChild(0).getChild(2).getChild(1).getChild(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }catch (Exception e){ }
    }

    private void enterAcessCode(AccessibilityEvent accessibilityEvent){
        try {
            Bundle arguments = new Bundle();
            arguments.putCharSequence(AccessibilityNodeInfo
                    .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "judy77");
            accessibilityEvent.getSource().getChild(0).getChild(0).getChild(0).getChild(1).performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);
            accessibilityEvent.getSource().getChild(0).getChild(0).getChild(0).getChild(3).performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }catch (Exception e){

        }
    }

    private void inputDestinationAccount(AccessibilityEvent accessibilityEvent){
        try {
            Bundle arguments = new Bundle();
            arguments.putCharSequence(AccessibilityNodeInfo
                    .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "judy77");
            accessibilityEvent.getSource().getChild(0).getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);
            accessibilityEvent.getSource().getChild(0).getChild(0).getChild(0).getChild(0).getChild(1).getChild(1).performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }catch (Exception e){

        }
    }

    private void selectDestinationAccount(AccessibilityEvent accessibilityEvent){
        try {
            Bundle arguments = new Bundle();
            arguments.putCharSequence(AccessibilityNodeInfo
                    .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "judy77");
            accessibilityEvent.getSource().getChild(0).getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);
            accessibilityEvent.getSource().getChild(0).getChild(1).getChild(0).getChild(0).getChild(0).getChild(2).performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }catch (Exception e){

        }
    }

    @Override
    public void onInterrupt() {

    }

}