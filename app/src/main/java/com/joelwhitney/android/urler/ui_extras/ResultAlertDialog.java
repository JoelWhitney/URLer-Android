//package com.joelwhitney.android.urler.ui_extras;
////
////import android.app.AlertDialog;
////import android.content.Context;
////import android.text.SpannableString;
////import android.text.method.LinkMovementMethod;
////import android.text.util.Linkify;
////import android.widget.TextView;
////
////import com.joelwhitney.android.urler.R;
////
////public class ResultAlertDialog {
////
////    @Override
////    public final AlertDialog create(Context context, String url) {
////        final TextView message = new TextView(context);
////        final SpannableString s = new SpannableString(url);
////        Linkify.addLinks(s, Linkify.WEB_URLS);
////        message.setText(s);
////        message.setMovementMethod(LinkMovementMethod.getInstance());
////
////        return new AlertDialog.Builder(context)
////                .setTitle(R.string.dialog_title)
////                .setCancelable(true)
////                .setIcon(android.R.drawable.ic_dialog_info)
////                .setPositiveButton(R.string.dialog_action_dismiss, null)
////                .setView(message)
////                .create();
////    }
////}