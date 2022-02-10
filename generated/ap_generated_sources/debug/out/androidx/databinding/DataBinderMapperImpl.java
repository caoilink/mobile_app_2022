package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new ie.wit.donationx.DataBinderMapperImpl());
  }
}
