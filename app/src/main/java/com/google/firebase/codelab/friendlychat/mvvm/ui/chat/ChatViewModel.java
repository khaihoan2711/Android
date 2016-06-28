package com.google.firebase.codelab.friendlychat.mvvm.ui.chat;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.google.firebase.codelab.friendlychat.mvvm.model.FriendlyMessage;
import com.google.firebase.codelab.friendlychat.mvvm.ui.base.BaseViewModel;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by henrytao on 6/19/16.
 */
public class ChatViewModel extends BaseViewModel {

    public String mEditText = "";
    public String mUsername = "";
    public String mPhotoUrl = "";
    public static final String MESSAGES_CHILD = "messages";

    public boolean mSendButtonEnableState = false;

    public ChatViewModel() {
    }

    public TextWatcher mEditTextWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable editable) {
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            mEditText = charSequence.toString().trim();
            if (charSequence.toString().trim().length() > 0) {
                mSendButtonEnableState = true;
            } else {
                mSendButtonEnableState = false;
            }
            notifyChange();
        }
    };

    public void OnSendButtonClick() {
        FriendlyMessage friendlyMessage = new
                FriendlyMessage(mEditText,
                mUsername,
                mPhotoUrl);
        FirebaseDatabase.getInstance().getReference().child(MESSAGES_CHILD)
                .push().setValue(friendlyMessage);
        mEditText = "";
        notifyChange();
    }

}
