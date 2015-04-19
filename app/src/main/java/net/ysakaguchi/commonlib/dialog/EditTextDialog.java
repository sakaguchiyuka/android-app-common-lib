package net.ysakaguchi.commonlib.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;

public class EditTextDialog extends DialogFragment {
    private DialogInterface.OnClickListener mOkClickListener;
    private DialogInterface.OnClickListener mCancelClickListener;
    private EditText mEditText;

    public static EditTextDialog newInstance(int title, int message) {
        EditTextDialog fragment = new EditTextDialog();
        Bundle args = new Bundle();
        args.putInt("title", title);
        args.putInt("message", message);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int titleId = getArguments().getInt("title");
        int messageId = getArguments().getInt("message");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(mEditText)
                .setPositiveButton("OK", mOkClickListener)
                .setNegativeButton("Cancel", mCancelClickListener);

        if (0 < titleId) {
            builder.setTitle(titleId);
        }

        if (0 < messageId) {
            builder.setMessage(messageId);
        }

        return builder.create();
    }

    /**
     * OKクリックリスナーの登録
     */
    public void setOnOkClickListener(DialogInterface.OnClickListener listener) {
        this.mOkClickListener = listener;
    }

    /**
     * Cancelクリックリスナーの登録
     */
    public void setOnCancelClickListener(DialogInterface.OnClickListener listener) {
        this.mCancelClickListener = listener;
    }

    /**
     * EditTextの登録
     */
    public void setEditText(EditText mEditText) {
        this.mEditText = mEditText;
    }
}
