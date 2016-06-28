package com.google.firebase.codelab.friendlychat.mvvm.ui.chat;

import com.google.firebase.codelab.friendlychat.databinding.ItemMessageBinding;
import com.google.firebase.codelab.friendlychat.mvvm.model.FriendlyMessage;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by henrytao on 6/19/16.
 */
public class ChatItemViewHolder extends RecyclerView.ViewHolder {

  private final ItemMessageBinding mBinding;

  private final ChatItemViewModel mViewModel;

  public ChatItemViewHolder(View itemView) {
    super(itemView);
    mViewModel = new ChatItemViewModel();
    mBinding = DataBindingUtil.bind(itemView);
    mBinding.setViewModel(mViewModel);
  }

  public void bind(FriendlyMessage message) {
    mViewModel.bind(message);
  }
}
