import SwiftUI

struct HostRideView: View {
    @State var from = ""
    @State var to = ""
    @State var time = ""
    @State var seats = 1
    @State var notes = ""
    
    var range = 1...10
    
    var body: some View {
        VStack {
            Text("Host a Ride")
                .font(.title)
            Spacer()
            TextField(
               "from",
               text: $from
           )
            TextField(
               "to",
               text: $to
           )
            TextField(
                "time"
                , text: $time
            )
            HStack {
                Text("seats: \($seats.wrappedValue)")
                Stepper(value: $seats, in: 1...99) {}
            }
            VStack {
                HStack {
                    Text("Notes:")
                    Spacer()
                }
                TextEditor(text: $notes)
                    .frame(height: 180)
                    .frame(width: .infinity)
                    .padding(8)
                    .cornerRadius(10)
                    .overlay(
                        RoundedRectangle(cornerRadius: 10)
                            .stroke(Color.gray.opacity(0.2), lineWidth: 1)
                    )
            }
            .padding(.vertical, 10)
            Spacer()
            Spacer()
            }
        .padding(.horizontal, 50)
        .textFieldStyle(.roundedBorder)
    }
}

#Preview {
    var model = Model()
    var viwModel = ViewModel(model: model)
    ContentView(selectedTab: 1, viewModel: viwModel)
}
