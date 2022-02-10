// Generated by view binder compiler. Do not edit!
package ie.wit.donationx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import ie.wit.donationx.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardReviewerBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView editTextTextPersonName;

  @NonNull
  public final ImageView imageIcon;

  @NonNull
  public final TextView paymentamount;

  @NonNull
  public final TextView paymentmethod;

  private CardReviewerBinding(@NonNull CardView rootView, @NonNull TextView editTextTextPersonName,
      @NonNull ImageView imageIcon, @NonNull TextView paymentamount,
      @NonNull TextView paymentmethod) {
    this.rootView = rootView;
    this.editTextTextPersonName = editTextTextPersonName;
    this.imageIcon = imageIcon;
    this.paymentamount = paymentamount;
    this.paymentmethod = paymentmethod;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CardReviewerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardReviewerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_reviewer, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardReviewerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.editTextTextPersonName;
      TextView editTextTextPersonName = rootView.findViewById(id);
      if (editTextTextPersonName == null) {
        break missingId;
      }

      id = R.id.imageIcon;
      ImageView imageIcon = rootView.findViewById(id);
      if (imageIcon == null) {
        break missingId;
      }

      id = R.id.paymentamount;
      TextView paymentamount = rootView.findViewById(id);
      if (paymentamount == null) {
        break missingId;
      }

      id = R.id.paymentmethod;
      TextView paymentmethod = rootView.findViewById(id);
      if (paymentmethod == null) {
        break missingId;
      }

      return new CardReviewerBinding((CardView) rootView, editTextTextPersonName, imageIcon,
          paymentamount, paymentmethod);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
