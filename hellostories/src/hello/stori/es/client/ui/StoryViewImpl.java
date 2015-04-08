package hello.stori.es.client.ui;

import hello.stori.es.client.parallax.MyScene;
import thothbot.parallax.core.client.RenderingPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class StoryViewImpl extends Composite implements StoryView {
    private static StoryViewImplUiBinder uiBinder = GWT.create(StoryViewImplUiBinder.class);

    interface StoryViewImplUiBinder extends UiBinder<Widget, StoryViewImpl> {}

    @UiField
    SimpleLayoutPanel vrContainer;

    private Presenter listener;

    public StoryViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onLoad() {
        // TODO Auto-generated method stub
//        RootLayoutPanel.get().setHeight("100%");
        
        RenderingPanel renderingPanel = new RenderingPanel();
        // Background color
        renderingPanel.setBackground(0x111111);
        renderingPanel.setAnimatedScene(new MyScene());

        // this.getParent().ad

        // RootLayoutPanel.get().add(renderingPanel);

        vrContainer.getParent().getParent().setHeight("100%");
        
        vrContainer.setWidget(renderingPanel);

        // super.onLoad();
    }

    @Override
    public void setName(String name) {
        GWT.log("setName di StoryViewImpl: " + name);
    }

    // @UiHandler("goodbyeLink")
    // void onClickGoodbye(ClickEvent e) {
    // listener.goTo(new GoodbyePlace(name));
    // }

    @Override
    public void setPresenter(Presenter listener) {
        this.listener = listener;
    }
}