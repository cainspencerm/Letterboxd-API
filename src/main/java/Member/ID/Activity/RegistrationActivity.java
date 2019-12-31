package Member.ID.Activity;

public class RegistrationActivity extends AbstractActivity<RegistrationActivity> {

    // @type is the only not-inherited variable, however @type is part of AbstractActivity, so
    // this class will be included for completeness.

    public RegistrationActivity(String json) {
        super(json);
    }

    @Override
    public RegistrationActivity getActivity() {
        return this;
    }
}
